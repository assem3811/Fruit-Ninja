package View;

class Control {
    private Command command;

    void SetCommand(Command command)
    {this.command=command;}
    void PressOnButton()
    {
        command.execute();
    }
}