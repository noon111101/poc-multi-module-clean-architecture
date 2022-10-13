package io.github.wesleyosantos91.v1.mapper;

import io.github.wesleyosantos91.person.domain.PersonDomain;
import io.github.wesleyosantos91.v1.request.PersonQueryRequest;
import io.github.wesleyosantos91.v1.request.PersonRequest;
import io.github.wesleyosantos91.v1.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PersonHttpMapper {

    PersonHttpMapper INSTANCE = Mappers.getMapper(PersonHttpMapper.class);
    PersonDomain toDomain(PersonRequest request);
    PersonDomain toDomain(PersonQueryRequest request);
    PersonRequest toRequest(PersonDomain domain);

    PersonDomain toDomain(PersonResponse response);
    PersonResponse toResponse(PersonDomain domain);


    default List<PersonResponse> toListResponse(List<PersonDomain> domains){
        List<PersonResponse> list = new ArrayList<>();
        domains.forEach(d-> list.add(toResponse(d)));
        return list;
    }

//    default Page<PersonResponse> toPageResponse(Page<PersonDomain> pages){
//        List<PersonResponse> list = toListResponse(pages.getContent());
//        return new PageImpl<>(list, pages.getPageable(), pages.getTotalElements());
//    }
}
