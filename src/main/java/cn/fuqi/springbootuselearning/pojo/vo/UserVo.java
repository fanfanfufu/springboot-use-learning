package cn.fuqi.springbootuselearning.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author FuQi
 * @date 2021/11/24 22:36
 * @description
 */
@Accessors(chain = true)
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = -5495955879044435087L;

    private Long id;

    private String userId;

    private String username;

    private Integer gender;

    private Integer age;

    private String hobby;
}
