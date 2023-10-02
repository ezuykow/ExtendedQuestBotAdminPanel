package ru.ezuykow.extendedquestbotadminpanel.view.question;

import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ezuykow.extendedquestbotadminpanel.entity.Question;

import ru.ezuykow.extendedquestbotadminpanel.entity.User;
import ru.ezuykow.extendedquestbotadminpanel.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


/**
    * @author ezuykow
*/
@Route(value = "questions/:id", layout = MainView.class)
@ViewController("Question.detail")
@ViewDescriptor("question-detail-view.xml")
@EditedEntityContainer("questionDc")
public class QuestionDetailView extends StandardDetailView<Question> {

    @Autowired
    private CurrentAuthentication currAuth;

    @ViewComponent
    private EntityPicker<User> authorField;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Question> event) {
        User user = (User) currAuth.getUser();
        event.getEntity().setAuthor(user);
        authorField.setReadOnly(true);
    }
}