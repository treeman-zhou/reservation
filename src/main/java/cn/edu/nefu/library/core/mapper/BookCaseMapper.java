package cn.edu.nefu.library.core.mapper;

import cn.edu.nefu.library.core.mapper.provider.BookCaseProvider;
import cn.edu.nefu.library.core.model.BookCase;
import cn.edu.nefu.library.core.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

/**
 * @author : chenchenT
 * @date : 2018/10/28
 * @since : Java 8
 */
@Mapper
@Repository
public interface BookCaseMapper {

    /**
     *通过用户ID获取书包柜信息
     * @param user 用户ID
     * @return bookCase 书包柜实体
     */
    @SelectProvider(type = BookCaseProvider.class, method = "selectByUserId")
    BookCase selectByUserId(User user);

    /**
     *设置预留的书包柜
     * @param bookCase 书包柜编号
     * @return 操作是否成功 1 成功 0 失败
     */
    @UpdateProvider(type = BookCaseProvider.class, method = "setByNumber")
    int setByNumber(BookCase bookCase);

    /**
     *通过书包柜编号建立/释放关系
     * @param bookcase 书包柜编号
     * @return 操作是否成功 1 成功 0 失败
     */
    @UpdateProvider(type = BookCaseProvider.class, method = "updateShipByNumber")
    int updateShipByNumber(BookCase bookcase);

}