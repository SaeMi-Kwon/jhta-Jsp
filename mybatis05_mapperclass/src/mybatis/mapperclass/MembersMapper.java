package mybatis.mapperclass;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import members.dto.MembersDto;

public interface MembersMapper {

	@Insert("insert into members values(#{num},#{name},#{phone},#{addr},sysdate)")
	int insert(MembersDto dto);  //메소드명은 맘대로 지정해도 된다
	
	@Delete("delete from members where num=#{num}")
	int delete(int num);
	
	@Update("update members set name=#{name},phone=#{phone},addr=#{addr} where num=#{num}")
	int update(MembersDto dto);
	
	@Select("select * from members where num=#{num}")
	MembersDto select(int num);
	
	@Select("select * from members")
	List<MembersDto> selectAll();
	
}
