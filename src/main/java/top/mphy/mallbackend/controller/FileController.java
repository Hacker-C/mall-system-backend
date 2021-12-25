package top.mphy.mallbackend.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialStruct;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin(origins = "http://119.23.46.102:8081", maxAge = 3600)
@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;

    private static final String ip = "http://119.23.46.102";

    @PostMapping("/upload")
    public ResponseData<?> upload(MultipartFile file) throws IOException {
        String originalFilename =  file.getOriginalFilename();
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir")+"/resources/files/"+ flag + "_" +originalFilename;
        FileUtil.writeBytes(file.getBytes(), rootFilePath);
        String url = ip + ":" + port + "/files/" + flag;
        return ResponseDataUtils.buildSuccess("0", "成功", url);
    }

    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {
        // 新建输出流对象
        OutputStream os;
        // 文件上传的根路径
        String basePath = System.getProperty("user.dir") + "/resources/files/";
        // 获取所有的文件名称
        List<String> listFileNames = FileUtil.listFileNames(basePath);
        // 找到和参数 flag 一致的文件
        String fileName = listFileNames.stream().filter(name->name.contains(flag)).findAny().orElse("");
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                //  通过文件的路径读取文件字节流
                byte[] bytes = FileUtil.readBytes(basePath + fileName);
                // 通过输出流返回文件
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件下载失败");
        }
    }

}
