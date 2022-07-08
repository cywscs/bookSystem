package Data.Mapper;

import Data.pojo.borrowInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface borrowinfoMapper {

    List<borrowInfo> selectByNum(@Param("num") int num);

    List<borrowInfo> selectByName(@Param("name") String name);

    List<borrowInfo> selectByCollege(@Param("college") String college);

    void borrowInfoAdd(@Param("num") int num, @Param("id") int id, @Param("sname") String sname, @Param("bname") String bname, @Param("deadline") String deadline);

    void returnInfoEdit(@Param("num") int num, @Param("id") int id);
}
