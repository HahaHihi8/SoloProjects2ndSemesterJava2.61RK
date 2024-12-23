package EMailValidator;

public class EMailValidator_Controller {
    final private EMailValidator_Model model;
    final private EMailValidator_View view;

    protected EMailValidator_Controller(EMailValidator_Model model, EMailValidator_View view) {
        this.model = model;
        this.view = view;

        view.txtEmail.textProperty().addListener(
            (observable, oldValue, newValue) -> validateEmailAddress(newValue)); //Lambda expression
    }

    private void validateEmailAddress(String newValue) {
        boolean valid = false;
  // Split the email address into two parts at the "@" symbol
        String[] addressParts = newValue.split("@");
        if (addressParts.length == 2 && !addressParts[0].isEmpty() && !addressParts[1].isEmpty()) {
 // Mail darf nicht mit einem Punkt enden (darf nicht das Trennzeichen sein!)
            if (addressParts[1].charAt(addressParts[1].length() - 1) != '.') {
 // Split bei "." ABER da "." ein Regular Expressions ist, muss es escaped werden (. hat eine Bedeutung in Regex)
                String[] domainParts = addressParts[1].split("\\.");
                if (domainParts.length >= 2) {
                    valid = true;
                    for (String s : domainParts) {
                        if (s.length() < 2) valid = false;
                    }
                }
            }
        }

        view.txtEmail.getStyleClass().remove("emailNotOk");
        view.txtEmail.getStyleClass().remove("emailOk");
        if (valid) {
            view.txtEmail.getStyleClass().add("emailOk");
        } else {
            view.txtEmail.getStyleClass().add("emailNotOk");
        }
    }
}

		
	


