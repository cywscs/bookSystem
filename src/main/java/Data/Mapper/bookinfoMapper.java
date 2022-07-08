package Data.Mapper;

import Data.pojo.bookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface bookinfoMapper {

    List<bookInfo> selectByName(@Param("name") String name);

    List<bookInfo> selectByAuthor(@Param("author") String author);

    List<bookInfo> selectByPress(@Param("press") String press);

    List<bookInfo> selectByNameUp();

    List<bookInfo> selectByIdUp();

    void bookInfoDeleteByName(@Param("name") String name);

    void bookInfoDeleteById(@Param("id") int id);

    void bookInfoAdd(bookInfo bookinfo);

    int bookNumberQuery(@Param("id") int id);

    void bookNumberDec(@Param("id") int id, @Param("bookNum") int bookNum);

    void bookNumberInc(@Param("id") int id, @Param("bookNum") int bookNum);

    void EditById(bookInfo bookinfo);

    void EditByName(bookInfo bookInfo);

    String getBname(@Param("id") int id);
}
