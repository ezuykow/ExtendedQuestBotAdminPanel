package ru.ezuykow.extendedquestbotadminpanel.view.questiongroup;

import ru.ezuykow.extendedquestbotadminpanel.entity.QuestionGroup;

import ru.ezuykow.extendedquestbotadminpanel.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


/**
    * @author ezuykow
*/
@Route(value = "questionGroups/:id", layout = MainView.class)
@ViewController("QuestionGroup.detail")
@ViewDescriptor("question-group-detail-view.xml")
@EditedEntityContainer("questionGroupDc")
public class QuestionGroupDetailView extends StandardDetailView<QuestionGroup> {
}