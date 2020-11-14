package luismunizdsconfig.personcrud.pages

import geb.Page

class CreatePersonPage extends Page {

    static url = '/person/create'

    static at = {
        title == 'Create Person'
    }

    static content = {
        submitButton { $('#create', 0) }
        firstNameInputField { $('#firstName', 0) }
        lastNameInputField { $('#lastName', 0) }
        firstNameErrorMessage { $('li', 'data-field-id':'firstName') }
    }

    void populateCreatePersonForm(String firstName, String lastName) {
        firstNameInputField << firstName
        lastNameInputField << lastName
        submitButton.click()
    }
}
