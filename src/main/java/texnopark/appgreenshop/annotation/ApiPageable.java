package texnopark.appgreenshop.annotation;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "page",dataType = "integer", paramType = "query",defaultValue = "0", value = "Sahifa indeksi(0...N)"),
        @ApiImplicitParam(name = "size", dataType = "integer",paramType = "query",defaultValue = "20", value = "Hat bitta sahifadagi elementlar soni"),
        @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",value = "Sort qilish creteriysi format: property()", allowMultiple = true)
})
public @interface ApiPageable {
    // page = 10,
    //size = 5,
    // sort = price,desc
}