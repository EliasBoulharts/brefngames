package Training.Controller;

import Game.GameSceneFactory;
import Player.*;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

public class TrainingController extends AbstractSceneManagerController {

    public TrainingController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new GameSceneFactory(new Player[]{new LocalPlayer(), new LocalPlayer()}));

        this.switchScene(SceneEnum.TRAINING_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            case END_TRAINING:
                // Call the parent (TrainingScene), this parent will call its own parent (LauncherController)
                // to change the current scene and destroy this scene manager controller
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;
            case TIC_TAC_TOE:
                return SceneEnum.TIC_TAC_TOE;
            case RUNNER:
                return SceneEnum.RUNNER;
            case CONNECT_FOUR:
                return SceneEnum.CONNECT_FOUR;
            case COOKIE_CLICKER:
                return SceneEnum.COOKIE_CLICKER;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}