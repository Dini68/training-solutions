package isahasa;

public class Client implements TextSource{

    private Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public void writeToChannel (TextSource textSource) {
        channel.writeByte(textSource.getPlainText().getBytes());
    }

    @Override
    public String getPlainText() {
        return null;
    }
}
