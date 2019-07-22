db.createUser({
  user: "user",
  pwd: "secretPassword",
  roles: [ { role: "readWrite", db: "users" } ]
})

db.users.insert({
  name: "user"
})
