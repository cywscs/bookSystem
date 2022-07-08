package Data.Mapper;

import Data.pojo.readerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface readerinfoMapper {

    void readerInfoAdd(readerInfo readerInfo);

    List<readerInfo> selectByNum(@Param("num") int num);

    List<readerInfo> selectByName(@Param("name") String name);

    List<readerInfo> selectByMajor_class(@Param("major_class") String major_class);

    List<readerInfo> selectByNumUp();

    List<readerInfo> selectByCollegeUp();

    void readerInfoDelete(@Param("num") int num, @Param("name") String name);

    void readerInfoEdit(readerInfo readerInfo);

    String getSname(@Param("num") int num);
}
