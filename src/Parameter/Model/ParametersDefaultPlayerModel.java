package Parameter.Model;

import Launcher.Controller.LauncherController;
import Parameter.Parameters.ColorParameter;
import Parameter.Parameters.Configurable;
import Parameter.Parameters.IconParameter;
import Structure.AbstractModel;

import java.util.Map;

public class ParametersDefaultPlayerModel extends AbstractModel {

    private Map<ParameterEnum, Configurable> configurations;

    public ParametersDefaultPlayerModel() {
        super();
        this.configurations = LauncherController.getConfiguration();
    }

    public void setPlayerColor(ParameterEnum player, String color) {
        ColorParameter colorParameter = new ColorParameter(ColorParameter.getColorFromString(color), color);
        this.configurations.replace(player, colorParameter);
    }

    public void setPlayerIcon(ParameterEnum player, String iconName) {
        IconParameter iconParameter = new IconParameter(IconParameter.getImageFromString(iconName), iconName);
        this.configurations.replace(player, iconParameter);
    }

    public Map<ParameterEnum, Configurable> getConfigurations() {
        return this.configurations;
    }
}
