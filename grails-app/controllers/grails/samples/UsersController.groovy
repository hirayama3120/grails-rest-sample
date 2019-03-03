package grails.samples

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class UsersController {

    static responseFormats = ['json', 'xml']

    def usersService

    def index() { 
        def usersList = usersService.findAllByUsers()

        respond usersList
    }

    def show(Integer id) {
        def user = usersService.get(id)

        if (!user) {
            render status: NOT_FOUND
            return
        }

        respond user
    }

    def save() {
        def user = new Users()
        bindData(user, request.JSON)

        user = usersService.save(user)

        if (user.hasErrors()) {
            respond user.errors
        }
        else {
            respond user, status: CREATED
        }
    }

    def update(Users user) {
        bindData(user, request.JSON)

        if (!user) {
            render status: NOT_FOUND
        }
        else {
            usersService.update(user)

            respond user, status: OK
        }
    }

    def delete(Users user) {
        if (!user) {
            render status: NOT_FOUND
        }
        else {
            usersService.delete(user)

            render status: NO_CONTENT
        }
    }
}
