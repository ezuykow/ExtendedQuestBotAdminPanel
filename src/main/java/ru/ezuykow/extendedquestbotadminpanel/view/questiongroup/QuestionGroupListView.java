package ru.ezuykow.extendedquestbotadminpanel.view.questiongroup;

import ru.ezuykow.extendedquestbotadminpanel.entity.QuestionGroup;

import ru.ezuykow.extendedquestbotadminpanel.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


/**
    * @author ezuykow
*/
@Route(value = "questionGroups", layout = MainView.class)
@ViewController("QuestionGroup.list")
@ViewDescriptor("question-group-list-view.xml")
@LookupComponent("questionGroupsDataGrid")
@DialogMode(width = "64em")
public class QuestionGroupListView extends StandardListView<QuestionGroup> {
}