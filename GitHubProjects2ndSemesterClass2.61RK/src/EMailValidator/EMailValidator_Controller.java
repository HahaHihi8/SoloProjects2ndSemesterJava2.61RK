package EMailValidator;

public class EMailValidator_Controller {
    final private EMailValidator_Model model;
    final private EMailValidator_View view;

    protected EMailValidator_Controller(EMailValidator_Model model, EMailValidator_View view) {
        this.model = model;
        this.view = view;

        view.txtEmail.textProperty().addListener(
            (observable, oldValue, newValue) -> validateEmailAddress(newValue));
    }

    private void validateEmailAddress(String newValue) {
        boolean valid = false;

        String[] addressParts = newValue.split("@");
        if (addressParts.length == 2 && addressParts[0].length() > 0 && addressParts[1].length() > 0) {
            if (addressParts[1].charAt(addressParts[1].length() - 1) != '.') {
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

		
	


