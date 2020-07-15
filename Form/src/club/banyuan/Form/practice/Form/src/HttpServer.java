package club.banyuan.Form.practice.Form.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpServer {

  static User user;



  public static void main(String[] args) throws IOException {
    // TODO 读文件
    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      Socket clientSocket = serverSocket.accept();
      InputStream inputStream = clientSocket.getInputStream();
      System.out.println(clientSocket.getInetAddress().getHostAddress());
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line = bufferedReader.readLine();
      StringTokenizer tokenizer = new StringTokenizer(line);
      MbmRequest mbmRequest = new MbmRequest();
      mbmRequest.setMethod(tokenizer.nextToken());
      mbmRequest.setPath(tokenizer.nextToken());
//      while (line != null && line.length() != 0) {
//        if (line.startsWith("Host:")) {
//          mbmRequest.setHost(line.replace("Host: ", ""));
//        }
//        System.out.println(line);
//        line = bufferedReader.readLine();
//      }
//
//      System.out.println(mbmRequest);
      while (line != null && line.length() != 0) {
        if (line.contains("${name}")) {
          mbmRequest.setName(line.replace("${name}", user.getName()));

        }

        if (line.contains("${pwd}")) {
          mbmRequest.setPwd(line.replace("${pwd}", user.getPwd()));

        }
        System.out.println(line);
        line = bufferedReader.readLine();
      }
      System.out.println(mbmRequest);


      // 写返回值
    }

  }
}
