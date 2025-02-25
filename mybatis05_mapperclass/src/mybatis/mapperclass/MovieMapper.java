package mybatis.mapperclass;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import members.dto.MovieDTO;

public interface MovieMapper {

	@Insert("insert into movie values(movie_seq.nextval,#{title},#{content},#{director})")
	int insert(MovieDTO dto);
	
	@Update("update movie set title=#{title},content=#{content},director=#{director} where mnum=#{mnum}")
	int update(MovieDTO dto);
	
	@Delete("delete from movie where mnum=#{mnum}")
	int delete(int num);
	
	@Select("select * from movie where mnum=#{mnum}")
	MovieDTO select(int num);
	
	@Select("select * from movie")
	List<MovieDTO> selectAll();
	
}
