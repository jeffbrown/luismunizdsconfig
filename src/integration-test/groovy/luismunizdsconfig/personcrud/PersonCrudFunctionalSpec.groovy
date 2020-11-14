package luismunizdsconfig.personcrud

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import luismunizdsconfig.personcrud.pages.CreatePersonPage
import luismunizdsconfig.personcrud.pages.PersonListPage
import luismunizdsconfig.personcrud.pages.ShowPersonPage
import spock.lang.Stepwise

@Integration
@Stepwise
class PersonCrudFunctionalSpec extends GebSpec {

    void "test creating a person"() {
        when:
        to CreatePersonPage

        then:
        at CreatePersonPage

        when:
        populateCreatePersonForm 'Jeff', 'Brown'

        then:
        at ShowPersonPage
    }

    void "test a person with a lower case first name"() {
        when:
        to CreatePersonPage

        then:
        at CreatePersonPage

        when:
        populateCreatePersonForm 'jeff', 'Brown'

        then:
        at CreatePersonPage

        and:
        firstNameErrorMessage.text() == 'First Name Must Begin With An Upper Case Letter'
    }

    void "test retrieving people"() {
        when:
        to PersonListPage

        then:
        numberOfPersonRows == 1
    }
}
