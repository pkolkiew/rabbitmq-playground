package pl.pk.rabbitmqplayground;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author pkolkiew
 * Created 10/28/2020
 */
class StreamListTest {

    public static void main(String[] args) {

    }

}

class Draft {
    private List<Section> sections;
}

class Section {
    private String sectionCode;
    private List<Field> fields;
}

class Field {
    private String fieldId;
    private String value;
}


@AllArgsConstructor
class VerificationRules {
    private final String fieldId;
    private final List<DraftVerifications> draftVerificationsList;
}

class DraftVerifications {

}

class FieldValidation {
    private String fieldId; // REQUIRED
    private String msg; // FIELD IS REQUIRED
}