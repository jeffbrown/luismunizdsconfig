package luismunizdsconfig

class Person {
    String firstName
    String lastName
    static constraints = {
        firstName matches: /[A-Z].*/
    }
}
