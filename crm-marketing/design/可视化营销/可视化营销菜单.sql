     
insert into t_auth_function
  (FID,
   FFUNCTIONCODE,
   FFUNCTIONNAME,
   FURI,
   FFUNCTIONLEVEL,
   FPARENTCODE,
   FVALIDFLAG,
   
   FDISPLAYORDER,
   
   FISCHECK,
   FFUNCTIONTYPE,
   
   FFUNCTIONDESC,
   FFUNCTIONSEQ,
   FCREATEUSERID,
   FCREATETIME,
   FLASTMODIFYUSERID,
   FLASTUPDATETIME)
   values(
   '01005017',
   '01005017',
   '���ӻ�Ӫ��',
   '/marketing/visualMarketing.action',
   4,
   '01005',
   1,
   17,
   1,
   3,
   '���ӻ�Ӫ��',
   '0/01/01005/01005017',
   1,
   sysdate,
   1,
   sysdate
   );
