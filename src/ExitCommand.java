public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Программа завершена без сохранения в файл");
        System.exit(1);
    }
}
