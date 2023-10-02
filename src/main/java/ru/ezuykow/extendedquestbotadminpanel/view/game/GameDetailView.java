package ru.ezuykow.extendedquestbotadminpanel.view.game;

import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ezuykow.extendedquestbotadminpanel.entity.Game;

import ru.ezuykow.extendedquestbotadminpanel.entity.User;
import ru.ezuykow.extendedquestbotadminpanel.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


/**
    * @author ezuykow
*/
@Route(value = "games/:id", layout = MainView.class)
@ViewController("Game.detail")
@ViewDescriptor("game-detail-view.xml")
@EditedEntityContainer("gameDc")
public class GameDetailView extends StandardDetailView<Game> {

    @Autowired
    private CurrentAuthentication currAuth;

    @ViewComponent
    private EntityPicker<User> authorField;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Game> event) {
        User user = (User) currAuth.getUser();
        event.getEntity().setAuthor(user);
        authorField.setReadOnly(true);
    }

}