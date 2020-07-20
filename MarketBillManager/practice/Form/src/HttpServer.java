import club.banyuan.mbm.server.MbmRequest;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class HttpServer extends Thread{
  private Socket socket;
  static Users users;

  public HttpServer(Socket Socket) {
    this.socket = Socket;
  }

  static Map<String,String> formData;

  @Override
  public void run() {
    try {
      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
      MbmRequest mbmRequest = MbmRequest.parse(reader);
      String path = mbmRequest.getPath();

      if("/".contains(path)) {
        responseHtml("/login.html",outputStream);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void responseHtml(String path, DataOutputStream outputStream) throws IOException{
    InputStream resourceAsStram = null;
    resourceAsStram = HttpServer.class.getClassLoader().getResourceAsStream("pages" + path);

  }

  public static void main(String[] args) {
    // TODO 读文件
    String line = "";
    if (line.contains("${name}")) {
      line.replace("${name}", users.getName());
    }

    if (line.contains("${pwd}")) {
      line.replace("${pwd}", users.getPwd());
    }

    // 写返回值
  }
}
