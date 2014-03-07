create tablespace tbs_bhpjt datafile 'tbs_bhpjt' size 200m;
create user bhpjt identified by bhpjt temporary tablespace temp default tablespace tbs_bhpjt;

grant connect, resource to bhpjt;



--alter system set processes=300 scope=spfile;
--alter system set sessiones=335 scope=spfile;
--shutdown immediate/abort;
--startup;