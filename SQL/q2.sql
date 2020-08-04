SELECT COUNT(member.name)
   FROM member
   WHERE member.id NOT IN (
   SELECT checkout_item.member_id
   FROM checkout_item, member
   WHERE checkout_item.member_id = member.id
);