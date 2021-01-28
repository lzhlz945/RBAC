SELECT p.`name`,p.url,p.icon,p.id,pr.rid FROM
permission p LEFT JOIN prid pr
on p.id=pr.pid
join urid ur
on pr.rid=ur.rid
WHERE ur.uId=2