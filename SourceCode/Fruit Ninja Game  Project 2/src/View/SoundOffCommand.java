package View;

public class SoundOffCommand implements Command {
    private Sound sound;

    public SoundOffCommand(Sound sound) {
        this.sound=sound;
    }

    @Override
    public void execute() {
        sound.switchoff();
    }
}