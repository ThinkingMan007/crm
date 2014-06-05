create or replace package PG_COU_COUPON is
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : �����ֶ������Ż�ȯ,�Զ����Ͷ��ŵĴ洢����
   */
  -- Author  : ADMINISTRATOR
  -- Created : 2012-12-12 10:54:54
  -- Purpose : �����ֶ������Ż�ȯ,�Զ����Ͷ��ŵĴ洢����
  
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : ��������1970��1��1�յ���ǰ�ĺ�����
   */  
   function FN_DATE_TO_NUMBER( i_date in timestamp) return number;
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : ���������Ż�ȯ����ĺ���
   */  
   function FN_COU_CREATECOUPON_NUM return VARCHAR2;
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : �����Զ����������ֶ��Ż�ȯ
   */  
   procedure SP_BACKGROUND_CREATE_COUPON( i_coupontype T_COU_MARKETPLAN.FCOUPONTYPE%TYPE,o_flag out number);
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : �����Զ�ȯ��������Ӧ�Ķ��ŷ�����Ϣ
   */ 
   procedure SP_AUTO_SEND_MSG( 
       i_senddeptcode T_COU_CELLPHONE_MSG_INFO.FSEND_STANDARD_DEPT_CODE%type,
       i_sendempcode T_COU_CELLPHONE_MSG_INFO.FSENDER_EMP_CODE%TYPE,
       o_flag out number);
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : �����ֶ�ȯ
   */ 
   procedure SP_CREATE_HAND_COUPON( 
              i_size in number,
              i_marketplanid in T_COU_MARKETPLAN.FID%TYPE,
              i_useruleid in T_COU_COUPONRULE.FID%TYPE,
              i_couponvalue in T_COU_COUPON.FVALUE%TYPE,
              o_flag out number);
end PG_COU_COUPON;
/
create or replace package body PG_COU_COUPON 

is
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : ��������1970��1��1�յ���ǰ�ĺ�����
   */  
   function FN_DATE_TO_NUMBER( i_date in timestamp)
   return number
   is
    l_number number; --����ֵ,���ؼ�����
   begin
    l_number := sysdate - to_date('1970-01-01','yyyy-mm-dd'); --���������
    return l_number;
   end FN_DATE_TO_NUMBER;
   
   
   
    /*
    author : ZhouYuan
    time : 2012-12-12
    version : 1.0
    discribe : ���������Ż�ȯ����ĺ���
    */  
   function FN_COU_CREATECOUPON_NUM 
   return VARCHAR2
   is
    TYPE rang_array IS TABLE OF VARCHAR2(1) INDEX BY BINARY_INTEGER; --����һ��table����
    char_array rang_array; --���������Զ���table���͵ı���
    org_message T_COU_COUPON_ORG_MESSAGE%ROWTYPE; 
    v_current VARCHAR2(12); --���ڴ�ż���couponnum���м�8λ��
    v_couponnum VARCHAR2(25);--���ڴ�����ɵ��Ż�ȯ����
    v_verify number := 0; --����У��λ
    v_temp VARCHAR2(1); --��ʱ����,���ڽ���
    l_flag number := 0; --�ж��Ż�ȯ�����Ƿ���ڳ�ʼֵ,����0,С��1
    e_nomorecoupon exception; --�쳣�� �����׳��쳣:�Ż�ȯ��������,�������ɸ����Ż�ȯ
    pragma exception_init(e_nomorecoupon,-21069); --���쳣����
    pragma autonomous_transaction;
  begin
         --��ѯ�Ż�ȯ��Ϣ��,��ѯ��ʼֵ,��ǰֵ,��ʱ��
         SELECT * INTO org_message FROM T_COU_COUPON_ORG_MESSAGE WHERE ROWNUM = 1 FOR UPDATE; 
         --������е�ʱ��С�ڵ�ǰʱ����±�����Ϣ
         if to_char(org_message.ORG_DATE,'yymmdd') < to_char(sysdate,'yymmdd') then
            update T_COU_COUPON_ORG_MESSAGE set ORG_DATE=sysdate,ORG_NUMBER=substr(FN_DATE_TO_NUMBER(sysdate),-8,8),ORG_CURRENT=substr(FN_DATE_TO_NUMBER(sysdate),-8,8)
            where rownum =1 RETURNING ORG_DATE,ORG_NUMBER,ORG_CURRENT INTO org_message;
            --���²�ѯһ��
            --SELECT * INTO org_message FROM T_COU_COUPON_ORG_MESSAGE WHERE ROWNUM = 1;
         end if;
         --�����ǰ����С�ڳ�ʼֵ,����־λ��1
         if org_message.org_number > org_message.org_current then
            l_flag := 1;
         end if;
          --����ǰֵ��һ�������20λ����
          v_current := trunc(org_message.ORG_CURRENT+DBMS_RANDOM.VALUE(1,20));
          --�������������8λ�������ȡ��8λ����
          if length(v_current) >= 8 then
              v_current := to_char(substr( v_current ,-8,8),'00000000');
          else
              --�������8λ,������ǰ��0
              v_current := to_char(v_current ,'00000000');
          end if;
              --ȥ����ǰ��ո�
              v_current := trim(v_current);
         --�ж��Ƿ������ɸ����Ż�ȯ
         if (org_message.org_number < v_current and l_flag = 0)or(org_message.org_number > v_current and l_flag = 1)then
          for v_i in 1 .. length(v_current) loop
               char_array(v_i) := SUBSTR(v_current,v_i,1);
               --����У��λ
               v_verify := v_verify + SUBSTR(v_current,v_i,1); 
      
          end loop;
           --�����ɵ��Ż�ȯ��Ϣ��4�ν���
           v_temp := char_array(7);
           char_array(7) := char_array(2);
           char_array(2) := v_temp;
           v_temp := char_array(6);
           char_array(6) := char_array(2);
           char_array(2) := v_temp; 
           v_temp := char_array(5);
           char_array(5) := char_array(7);
           char_array(7) := v_temp; 
           v_temp := char_array(1);
           char_array(1) := char_array(4);
           char_array(4) := v_temp;
  
           v_couponnum := '';
           --ƴװ�Ż�ȯ����
           for v_i in 1 .. 8 loop
               v_couponnum := v_couponnum || char_array(v_i);
           end loop;
           v_couponnum := to_char(sysdate,'yymmdd')||v_couponnum||substr(v_verify,-1,1);
           update t_cou_coupon_org_message set ORG_CURRENT = v_current;
           commit;
           return v_couponnum;
           else 
                 raise e_nomorecoupon; 
           end if;
           exception
                 when no_data_found then --û���ҵ����ݲ���
                    INSERT INTO T_COU_COUPON_ORG_MESSAGE( ORG_DATE,ORG_NUMBER,ORG_CURRENT ) 
                           VALUES( SYSDATE,PG_COU_COUPON.FN_DATE_TO_NUMBER(SYSDATE),
                                   PG_COU_COUPON.FN_DATE_TO_NUMBER(SYSDATE));
                    COMMIT;
                    when e_nomorecoupon then
                         ROLLBACK;
                         raise e_nomorecoupon;
                 when others then
                    ROLLBACK;
  end FN_COU_CREATECOUPON_NUM;
    /*
    author : ZhouYuan
    time : 2012-12-12
    version : 1.0
    discribe : ���ڷ��Ͷ������ɶ��ŷ�����Ϣ
    */  
  function fn_create_send_msg(
       i_headmsg in T_COU_COUPONRULE.Fsms%type, --�Ż�ȯ�û��Զ�����Ϣ
       i_couponvalue in T_COU_COUPON.Fvalue%type, --�Ż�ȯ��ֵ
       i_couponnumber in T_COU_COUPON.Fnumber%type, --�Ż�ȯ����
       i_endtime in T_COU_COUPONRULE.Fendtime%type) --ʹ�ý�ֹʱ��
  return varchar2
  is
        v_msg varchar2(500);
        begin
        --���ɶ���������Ϣ
        v_msg := i_headmsg||' '||i_couponvalue||' Ԫ�Ż�ȯ,����: '||i_couponnumber||' ,��Ч���� '||
               to_char(i_endtime,'yy')||'��'||to_char(i_endtime,'mm')||'��'||to_char(i_endtime,'dd')||'��'||' ����ȯ��������ѯ����Ӫҵ��!';
        return v_msg;
  end;
  
    /*
    author : ZhouYuan
    time : 2012-12-12
    version : 1.0
    discribe : ���ڴ����Ż�ȯ
    */  
    procedure sp_create_coupon(
              i_size in number,--����������
              i_marketplanid in T_COU_COUPON.Fmarketplanid%TYPE, --Ӫ���ƻ�ID
              i_typeid in T_COU_COUPON.Ftypeid%TYPE, --�Ż�ȯ����
              i_createruleid in T_COU_COUPON.Fcreateruleid%type, --��������
              i_useruleid in T_COU_COUPON.Fuseruleid%type, --ʹ�ù���
              i_status in T_COU_COUPON.Fstatus%type, --�Ż�ȯ״̬
              i_underdept in T_COU_COUPON.Funderdept%type, --�Ż�ȯ��������
              i_sendtelphone in T_COU_COUPON.Fsendtelphone%type, --�����ֻ���
              i_usetelphone in T_COU_COUPON.Fusetelphone%type, --ʹ���ֻ���
              i_sourcewbnumber in T_COU_COUPON.Fsourcewbnumber%type, --��Դ�˵�����
              i_sourcewbvalue in T_COU_COUPON.Fsourcewbvalue%type, --��Դ�˵����
              i_usewbnumber in T_COU_COUPON.Fusewbnumber%type, --ʹ���˵����
              i_usewbvalue in T_COU_COUPON.Fusewbvalue%type, --ʹ���˵����
              i_couponvalue in T_COU_COUPON.Fvalue%type, --�Ż�ȯ���
              o_flag out number)
    is
     -- v_couponnumber T_COU_COUPON.FNUMBER%TYPE;--�����Ż�ȯ���� 
              type coupon_table_type is table of 
                   T_COU_COUPON%ROWTYPE index by binary_integer; --����һ������������ΪT_COU_COUPON
              coupon_table coupon_table_type;      
    begin     
              o_flag := 0;
              for v_i in 1 .. i_size loop
                 coupon_table(v_i).fid := SEQ_ID_COUPON.NEXTVAL;
                 coupon_table(v_i).fnumber :=  PG_COU_COUPON.FN_COU_CREATECOUPON_NUM;
                 coupon_table(v_i).fmarketplanid := i_marketplanid;
                 coupon_table(v_i).ftypeid := i_typeid;
                 coupon_table(v_i).fcreateruleid := i_createruleid;
                 coupon_table(v_i).fuseruleid := i_useruleid;
                 coupon_table(v_i).fstatus := i_status;
                 coupon_table(v_i).funderdept := i_underdept;
                 coupon_table(v_i).fsendtelphone := i_sendtelphone;
                 coupon_table(v_i).fusetelphone := i_usetelphone;
                 coupon_table(v_i).fsourcewbnumber := i_sourcewbnumber;
                 coupon_table(v_i).fsourcewbvalue := i_sourcewbvalue;
                 coupon_table(v_i).fusewbnumber := i_usewbnumber;
                 coupon_table(v_i).fusewbvalue := i_usewbnumber;
                 coupon_table(v_i).fvalue := i_couponvalue;
                 coupon_table(v_i).fsmstimes := 0;
                 coupon_table(v_i).fsendtime := sysdate;
                 coupon_table(v_i).fcreatetime := sysdate;
              end loop;

              forall v_i in coupon_table.first .. coupon_table.last 
                     insert into t_cou_coupon values coupon_table(v_i);

              o_flag := 1;
    exception
         when others then 
              ROLLBACK;

    end sp_create_coupon; 
    /*
    author : ZhouYuan
    time : 2012-12-12
    version : 1.0
    discribe : ���ڷ��Ͷ���
    */ 
  procedure sp_create_send_msg(
       i_couponnumber in T_COU_CELLPHONE_MSG_INFO.Fcounpon_Number%type,--�Ż�ȯ����
       i_phonenumber in T_COU_CELLPHONE_MSG_INFO.Fphone_Number%type, --�����ֻ���
       i_msgcontent in T_COU_CELLPHONE_MSG_INFO.Fmsgcontent%type, --���Ͷ�������
       i_sendstandarddept in T_COU_CELLPHONE_MSG_INFO.Fsend_Standard_Dept_Code%type, --���Ͳ���
       i_senderempcode in T_COU_CELLPHONE_MSG_INFO.Fsender_Emp_Code%type, --���͹�Ա
       i_sended in T_COU_CELLPHONE_MSG_INFO.Fis_Sended%type --���ͱ�ʶ
       )
   is 
   begin
       insert into T_COU_CELLPHONE_MSG_INFO(
              FID,
              FCOUNPON_NUMBER,
              FPHONE_NUMBER,
              FMSGCONTENT,
              FSEND_STANDARD_DEPT_CODE,
              FSENDER_EMP_CODE,
              FIS_SENDED,
              FCREATETIME
        )VALUES(
              SEQ_T_COU_PHONE_MSG_INFO.NEXTVAL,
              i_couponnumber,
              i_phonenumber,
              i_msgcontent,
              i_sendstandarddept,
              i_senderempcode,
              i_sended,
              sysdate    
        );
    end; 
    
    /*
    author : ZhouYuan
    time : 2012-12-12
    version : 1.0
    discribe : �����Զ�ȯ���ɷ��Ͷ���
    */ 
    procedure sp_auto_send_msg(
       i_senddeptcode T_COU_CELLPHONE_MSG_INFO.FSEND_STANDARD_DEPT_CODE%type, --���Ͳ��ű���
       i_sendempcode T_COU_CELLPHONE_MSG_INFO.Fsender_Emp_Code%type, --���͹�Ա����
       o_flag out number
    )
    is
    type record_waybill_type IS RECORD( 
        wbid T_COU_WAYBILL_COUPON.Fid%type, --�˵�ID
        waybillnumber T_COU_WAYBILL_COUPON.Fwaybillnumber%type, --�˵�����
        marketplanid T_COU_MARKETPLAN.Fid%type, --Ӫ���ƻ�ID
        marketplannumber T_COU_WAYBILL_COUPON.Fmarketplannumber%type, --Ӫ���ƻ�����
        coupontype T_COU_MARKETPLAN.Fcoupontype%type, --�Ż�ȯ����
        underdept T_COU_WAYBILL_COUPON.Funderdept%type, --�Ż�ȯ��������
        sendtelphone T_COU_WAYBILL_COUPON.Fsendtelphone%type, --�Ż�ȯ�����ֻ�
        wbvalue T_COU_WAYBILL_COUPON.Fwbvalue%type, --�˵��������
        couponvalue T_COU_WAYBILL_COUPON.Fvalue%type, --�Ż�ȯ���
        status T_COU_WAYBILL_COUPON.Fstatus%type, --�˵�״̬
        createtime T_COU_WAYBILL_COUPON.Fcreatetime%type, --�˵�����ʱ��
        createruleid T_COU_RULECOUPONAUTO.Fid%type, --�Ż�ȯ��������
        useruleid T_COU_COUPONRULE.Fid%type, --�Ż�ȯʹ�ù���
        msgcontent T_COU_COUPONRULE.Fsms%type, --�û��Զ�����Ϣ
        begintime T_COU_COUPONRULE.Fbegintime%type, --ʹ�ÿ�ʼʱ��
        endtime T_COU_COUPONRULE.Fendtime%type); --ʹ�ý���ʱ��
        
        record_waybill record_waybill_type;
        
        type cursor_type is ref cursor return record_waybill_type; --�����α����ڲ�ѯ�˵��м��
        my_cursor cursor_type ;
        --�����Ż�ȯ������
        type coupon_table_type is table of T_COU_COUPON%ROWTYPE index by binary_integer;
        coupon_table coupon_table_type;
        --�������ŷ���������
        type send_msg_table_type is table of T_COU_CELLPHONE_MSG_INFO%ROWTYPE index by binary_integer;
        send_msg_table send_msg_table_type;
        
        type wbid_table_type is table of T_COU_WAYBILL_COUPON.FID%TYPE index by binary_integer;
        wbid_table wbid_table_type;
        
        record_send_msg T_COU_CELLPHONE_MSG_INFO%ROWTYPE; --����record����,���ڴ�Ŷ��ŷ�����Ϣ
       -- v_couponnumber T_COU_COUPON.Fnumber%type; --���ڴ���Ż�ȯ����
        v_i number := 1;
   begin
   o_flag := 0;
   --��ѯ�˵��м��
   open my_cursor for SELECT
           B.FID wbid,
           B.FWAYBILLNUMBER waybillnumber,
           M.FID marketplanid,
           B.FMARKETPLANNUMBER marketplannumber,
           M.FCOUPONTYPE coupontype,
           B.FUNDERDEPT underdept,
           B.FSENDTELPHONE sendtelphone,
           B.FWBVALUE wbvalue,
           B.FVALUE couponvalue,
           B.FSTATUS status,
           B.FCREATETIME createtime,
           RU.FID createruleid,
           COU.FID useruleid,
           COU.FSMS msgcontent,
           COU.FBEGINTIME begintime,
           COU.FENDTIME endtime
        FROM
           T_COU_WAYBILL_COUPON B
        JOIN T_COU_MARKETPLAN M 
        ON B.FMARKETPLANNUMBER = M.FPLANNUMBER
        JOIN T_COU_COUPONRULE COU
        ON M.FID = COU.FMARKETPLANID
        JOIN T_COU_RULECOUPONAUTO RU
        ON COU.FMARKETPLANID = RU.FMARKETPLANID
        WHERE
           B.FSTATUS = '0'
        ORDER BY
          B.FMARKETPLANNUMBER;
      
    loop
          --��ȡ��ѯ��Ϣ
          fetch my_cursor into record_waybill;
          exit when my_cursor%notfound; 
              coupon_table(v_i).FID := SEQ_ID_COUPON.NEXTVAL;
              coupon_table(v_i).FMARKETPLANID := record_waybill.marketplanid;
              coupon_table(v_i).FNUMBER := FN_COU_CREATECOUPON_NUM;
              coupon_table(v_i).FTYPEID := 'AUTOCOUPON';
              coupon_table(v_i).FCREATERULEID := record_waybill.createruleid;
              coupon_table(v_i).FUSERULEID := record_waybill.useruleid;
              coupon_table(v_i).FSTATUS :='20';
              coupon_table(v_i).FUNDERDEPT := record_waybill.underdept;
              coupon_table(v_i).FSENDTELPHONE := record_waybill.sendtelphone;
              coupon_table(v_i).FSOURCEWBNUMBER := record_waybill.waybillnumber;
              coupon_table(v_i).FSOURCEWBVALUE :=  record_waybill.wbvalue;
              coupon_table(v_i).fsmstimes := 0;
              coupon_table(v_i).fsendtime := sysdate;
              coupon_table(v_i).fcreatetime := sysdate;
              coupon_table(v_i).FVALUE := record_waybill.couponvalue;
              
              
              send_msg_table(v_i).FID := SEQ_T_COU_PHONE_MSG_INFO.NEXTVAL;
              send_msg_table(v_i).FCOUNPON_NUMBER := coupon_table(v_i).FNUMBER;
              send_msg_table(v_i).FPHONE_NUMBER := record_waybill.sendtelphone;
              send_msg_table(v_i).FMSGCONTENT := fn_create_send_msg(
                                                 record_waybill.msgcontent, --�Ż�ȯ�û��Զ�����Ϣ
                                                 record_waybill.couponvalue, --�Ż�ȯ��ֵ
                                                 coupon_table(v_i).FNUMBER, --�Ż�ȯ����
                                                 record_waybill.endtime);
              send_msg_table(v_i).FSEND_STANDARD_DEPT_CODE := i_senddeptcode;
              send_msg_table(v_i).FSENDER_EMP_CODE := i_sendempcode;
              send_msg_table(v_i).FIS_SENDED := '0';
              send_msg_table(v_i).FCREATETIME := sysdate;   
              
              wbid_table(v_i) := record_waybill.wbid; 
              v_i := v_i+1;
              if coupon_table.count= 50000 then
                 forall l_i in coupon_table.first .. coupon_table.last 
                        insert into t_cou_coupon values coupon_table(l_i);
                 forall l_j in send_msg_table.first .. send_msg_table.last
                        insert into t_cou_cellphone_msg_info values send_msg_table(l_j);
                 forall l_t in  wbid_table.first .. wbid_table.last
                        update T_COU_WAYBILL_COUPON set FSTATUS = '1' where FID = wbid_table(l_t); 
                 commit;
                 coupon_table.delete;
                 send_msg_table.delete;
                 wbid_table.delete;
              end if;                              
      
         end loop;
         forall l_i in coupon_table.first .. coupon_table.last 
                        insert into t_cou_coupon values coupon_table(l_i);
         forall l_j in send_msg_table.first .. send_msg_table.last
                        insert into t_cou_cellphone_msg_info values send_msg_table(l_j);
         forall l_t in  wbid_table.first .. wbid_table.last
                        update T_COU_WAYBILL_COUPON set FSTATUS = '1' where FID = wbid_table(l_t); 
         commit;
         coupon_table.delete;
         send_msg_table.delete;
         wbid_table.delete;
         close my_cursor;
         o_flag := 1;
    exception
         when others then 
              ROLLBACK;
    end sp_auto_send_msg;
    
    /*
    author : ZhouYuan
    time : 2012-12-12
    version : 1.0
    discribe : ���ڴ����ֶ��Ż�ȯ
    */ 
    
    procedure sp_background_create_coupon( i_coupontype T_COU_MARKETPLAN.FCOUPONTYPE%type,o_flag out number)
is
   type record_hand_message is RECORD(
        marketplanid T_COU_MARKETPLAN.FID%TYPE,--Ӫ���ƻ�ID 
        savetime T_COU_MARKETPLAN.FSAVETIME%TYPE,--����ʱ��
        createdate T_COU_MARKETPLAN.FCREATETIME%TYPE,--����ʱ��
        createuser T_COU_MARKETPLAN.FCREATEUSERID%TYPE,--������
        modifydate T_COU_MARKETPLAN.FLASTUPDATTIME%TYPE,--�޸�ʱ��
        modifyuser T_COU_MARKETPLAN.FLASTMODIFYUSERID%TYPE,--�޸���
        modifyusername T_COU_MARKETPLAN.FMODIFYUSERNAME%TYPE,--�޸�������
        plannumber T_COU_MARKETPLAN.FPLANNUMBER%TYPE,--Ӫ���ƻ�����
        planname T_COU_MARKETPLAN.FPLANNAME%TYPE,--Ӫ���ƻ�����
        marketstatus T_COU_MARKETPLAN.FSTATUS%TYPE,--Ӫ���ƻ�״̬
        coupontype T_COU_MARKETPLAN.FCOUPONTYPE%TYPE,--�Ż�ȯ����
        createruleid T_COU_RULECOUPONHAND.FID%TYPE,--��������
        typeid T_COU_RULECOUPONHAND.FTYPEID%TYPE,--��������ID
        couponvalue T_COU_RULECOUPONHAND.FVALUE%TYPE,--�Ż�ȯ��ֵ
        useruleid T_COU_COUPONRULE.FID%TYPE,--ʹ�ù���ID
        quantity T_COU_RULECOUPONHAND.FQUANTITY%TYPE,--�Ż�ȯ��ֵ
        couponcreatenum number);--Ҫ��������Ŀ
   record_hand record_hand_message;
   type cursor_hand_message_type is ref cursor;
   cursor_hand_message cursor_hand_message_type;

    type coupon_table_type is table of 
                   T_COU_COUPON%ROWTYPE index by binary_integer; --����һ������������ΪT_COU_COUPON
    coupon_table coupon_table_type;    
begin
   o_flag := 0;
   --��ѯӪ���ƻ���Ϣ
   open cursor_hand_message for SELECT
          M.FID marketplanid,
          M.FSAVETIME savetime,
          M.FCREATETIME createdate,
          M.FCREATEUSERID createuser,
          M.FLASTUPDATTIME modifydate,
          M.FLASTMODIFYUSERID modifyuser,
          M.FMODIFYUSERNAME modifyusername,
          M.FPLANNUMBER plannumber,
          M.FPLANNAME planname,
          M.FSTATUS marketstatus,
          M.FCOUPONTYPE coupontype,
          R.FID createruleid,
          R.FTYPEID typeid,
          R.FVALUE couponvalue,
          COU.FID useruleid,
          NVL(R.FQUANTITY,0) quantity,
          NVL((NVL(R.FQUANTITY,0) - NVL(CCN.COUPONCREATENUM,0)),0) couponcreatenum
            FROM T_COU_MARKETPLAN M
            JOIN T_COU_RULECOUPONHAND R 
            ON M.FID = R.FMARKETPLANID
            JOIN T_COU_COUPONRULE COU
            ON R.FMARKETPLANID = COU.FMARKETPLANID
            LEFT JOIN
            (SELECT NVL(COUNT(1),0) COUPONCREATENUM,FMARKETPLANID FMARKETPLANID 
              FROM T_COU_COUPON
              GROUP BY FMARKETPLANID
             )  CCN
             ON M.FID=CCN.FMARKETPLANID
           WHERE M.FCOUPONTYPE = i_coupontype
          AND R.FTYPEID IN ('NOCREATE','FORSCHEDUAL' )
         -- AND ROWNUM = 1
          AND NVL((NVL(R.FQUANTITY,0) - NVL(CCN.COUPONCREATENUM,0)),0)>0;
       loop
           --��ȡ��ѯ��Ϣ
           fetch cursor_hand_message into record_hand;
           exit when cursor_hand_message%notfound;
           sp_create_coupon(

                     record_hand.couponcreatenum ,
                     record_hand.marketplanid ,
                     'HANDCOUPON',
                     record_hand.createruleid,
                     record_hand.useruleid ,
                     '10',
                     null,
                     null,
                     null,
                     null,
                     null,
                     null,
                     null,
                     record_hand.couponvalue,
                     o_flag );  
           update t_cou_rulecouponhand set FTYPEID = 'CREATED' where FMARKETPLANID = record_hand.marketplanid;
           commit; 
       end loop;
       close cursor_hand_message;
       o_flag := 1;
       exception
         when others then 
              ROLLBACK;
    end sp_background_create_coupon;
  
   /*
   author : ZhouYuan
   time : 2012-12-12
   version : 1.0
   discribe : �����ֶ�ȯ
   */ 
    procedure sp_create_hand_coupon( 
    
              
              i_size in number,--����������
              i_marketplanid in T_COU_MARKETPLAN.FID%TYPE,--Ӫ���ƻ�ID
              i_useruleid in T_COU_COUPONRULE.FID%TYPE,--ʹ�ù���ID
              i_couponvalue in T_COU_COUPON.FVALUE%TYPE,--�Ż�ȯ��ֵ
              o_flag out number)
    is   
             -- v_couponnumber T_COU_COUPON.FNUMBER%TYPE;--�����Ż�ȯ���� 
              type coupon_table_type is table of 
                   T_COU_COUPON%ROWTYPE index by binary_integer; --����һ������������ΪT_COU_COUPON
              coupon_table coupon_table_type;  
              v_times number;    
    begin     
              sp_create_coupon(
                     i_size ,
                     i_marketplanid ,
                     'HANDCOUPON',
                     null,
                     i_useruleid ,
                     '10',
                     null,
                     null,
                     null,
                     null,
                     null,
                     null,
                     null,
                     i_couponvalue ,
                     o_flag );
                     commit;
    end;
    
   end;
/
