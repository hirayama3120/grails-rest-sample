package grails.samples

class Users {

    //int id
    String firstName
    String lastName
    int age
    String mailAddress
    Boolean isActive = 1
	Date dateCreated
	Date lastUpdated

    static constraints = {
        age(nullable:true)
        mailAddress(nullable:true)
    }

    static mapping = {
        version false
    }
}
