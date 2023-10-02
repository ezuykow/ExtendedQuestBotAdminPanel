package ru.ezuykow.extendedquestbotadminpanel.view.question;

import ru.ezuykow.extendedquestbotadminpanel.entity.Question;

import ru.ezuykow.extendedquestbotadminpanel.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


/**
    * @author ezuykow
*/
@Route(value = "questions", layout = MainView.class)
@ViewController("Question.list")
@ViewDescriptor("question-list-view.xml")
@LookupComponent("questionsDataGrid")
@DialogMode(width = "64em")
public class QuestionListView extends StandardListView<Question> {
}