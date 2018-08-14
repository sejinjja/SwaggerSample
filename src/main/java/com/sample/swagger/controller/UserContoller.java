package com.sample.swagger.controller;

import com.sample.swagger.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user")
@Api(description = "# UserContoller\n" +
        "## 유저를 콘트롤 합니다.")
public class UserContoller {
    @GetMapping
    @ApiOperation("테스트1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = false, dataType = "string", paramType = "query", defaultValue = "")
    })
    public ArrayList<UserDTO> getUserList(@RequestParam(value = "title", required = false) String test) {
        ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
        for (int i = 0; i < 10; i++) {
            UserDTO userTemp = new UserDTO();
            userTemp.setId(i + "");
            userTemp.setName(i + "");
            userList.add(userTemp);
        }
        return userList;
    }

    @GetMapping("/{id}")
    @ApiOperation(value="test")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "유저 번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    public UserDTO getUser(@PathVariable int id){
        UserDTO findedUser = new UserDTO();
        if(id < 10){
            findedUser.setId(id + "");
            findedUser.setName(id + "");
        }
        return findedUser;
    }
}
