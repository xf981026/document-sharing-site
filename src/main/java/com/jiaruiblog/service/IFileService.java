package com.jiaruiblog.service;

import com.jiaruiblog.entity.dto.DocumentDTO;
import com.jiaruiblog.entity.FileDocument;
import com.jiaruiblog.util.BaseApiResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


/**
 * @author jiarui.luo
 */
public interface IFileService {


    /**
     * 保存文件 - 表单
     *
     * @param md5
     * @param file
     * @return
     */
    FileDocument saveFile(String md5, MultipartFile file);

    /**
     * 保存文件 - js文件流
     *
     * @param fileDocument
     * @param inputStream
     * @return
     */
    FileDocument saveFile(FileDocument fileDocument, InputStream inputStream);

    /**
     * 删除文件
     *
     * @param id
     * @param isDeleteFile 是否删除文件
     * @return
     */
    void removeFile(String id, boolean isDeleteFile);

    /**
     * 根据id获取文件
     *
     * @param id
     * @return
     */
    Optional<FileDocument> getById(String id);

    /**
     * 根据md5获取文件对象
     *
     * @param md5
     * @return
     */
    FileDocument getByMd5(String md5);

    /**
     * queryById
     * @param docId String
     * @return result
     */
    FileDocument queryById(String docId);

    /**
     * 分页查询，按上传时间降序
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<FileDocument> listFilesByPage(int pageIndex, int pageSize);

    /**
     * listAndFilterByPage
     * @param pageIndex int
     * @param pageSize int
     * @param ids Collection
     * @return result
     */
    List<FileDocument> listAndFilterByPage(int pageIndex, int pageSize, Collection<String> ids);

    /**
     * listAndFilterByPageNotSort
     * @param pageIndex int
     * @param pageSize int
     * @param ids List
     * @return result
     */
    List<FileDocument> listAndFilterByPageNotSort(int pageIndex, int pageSize, List<String> ids);

    /**
     * 分页检索目前的文档信息
     * @param documentDTO DocumentDTO
     * @return result
     */
    BaseApiResult list(DocumentDTO documentDTO);

    /**
     *根据文档的详情，查询该文档的详细信息
     *
     * @param id ->Long
     * @return ApiResult
     */
    BaseApiResult detail(String id);

    /**
     * 删除掉已经存在的文档
     *
     * @param id -> Long
     * @return ApiResult
     */
    BaseApiResult remove(String id);

    /**
     * update file thumb
     * @param inputStream FileDocument
     * @param fileDocument InputStream
     * @throws FileNotFoundException file not found
     */
    void updateFileThumb(InputStream inputStream, FileDocument fileDocument) throws FileNotFoundException;

    /**
     * getFileThumb
     * @Author luojiarui
     * @Description // 查询缩略图信息
     * @Date 8:00 下午 2022/7/24
     * @param thumbId String
     * @return java.io.InputStream
     **/
    InputStream getFileThumb(String thumbId);
}
