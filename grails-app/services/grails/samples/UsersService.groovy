package grails.samples

import grails.transaction.Transactional

@Transactional
class UsersService {

    List<Users> findAllByUsers() {
        Users.findAllByIsActive(true)
    }

    Users get(Integer id) {
        Users.get(id)
    }

    Users save(Users user) {
        assert !user.id

        if (user.validate()) {
             user.save flush:true
        }
        return user
    }

    def update(Users user) {
        assert user.id

        if (user.validate()) {
             user.save flush:true
        }
        return user
    }

    def delete(Users user) {
        user.isActive = false
    }

}
