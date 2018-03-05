package com.zll.dijiag.util.cipher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zll.dijiag.util.response.CipherResponse;
import com.zll.dijiag.util.response.Response;
import com.zll.dijiag.util.response.ResponseCode;

public class Crypto {

    /**
     * 返回加密数据给前台
     *
     * @param flag
     * @param data
     * @return
     */
    public static Response response(boolean flag, Object data) {
        Response response = new Response();
        if (flag) {
            response.setCode(ResponseCode.CODE_SUCCESS);
            response.setMsg("操作成功");
        } else {
            response.setCode(ResponseCode.CODE_FAIL);
            response.setMsg("操作失败");
        }
        response.setData(data);
        return response;
    }

    /**
     * 加密内容
     *
     * @param data
     * @return
     */
    public static CipherResponse encodeJson(Response data) {
        CipherResponse response = new CipherResponse();
        try {
            long secret = AES.get10Random();
            String content = AES.encrypt(JSON.toJSONString(data), AES.md5(AES.longMinusNum(secret + "")));
            response.setSecret(secret);
            response.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

//    public static void main(String[] args) {
//        String json = "{ \"content\":\"Scwpj/E+k7l8Ehr12627fKtYpjPSpBsnpRmXRyJhLVttKxAaMKOBh1zCO6CfP4c8\", \"secret\":\"3652498590\" }";
//        System.out.println(decryptJson(json));
//    }

    /**
     * 解密内容
     *
     * @param json
     * @return
     */
    public static String decryptJson(String json) {
        String result = json;
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            String secret = jsonObject.getString("secret");
            String content = jsonObject.getString("content");
            result = AES.decrypt(content, AES.md5(AES.longMinusNum(secret)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
