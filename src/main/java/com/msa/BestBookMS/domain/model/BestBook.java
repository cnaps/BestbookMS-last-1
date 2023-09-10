package com.msa.BestBookMS.domain.model;

import com.msa.BestBookMS.domain.model.vo.Item;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestBook {
@Id
private String id;

private Item item;
private Long rentCount;

public static BestBook registerBestBook(Item item){
    UUID uuid = UUID.randomUUID();
    var bestBook = new BestBook();
    bestBook.setId(uuid.toString());
    bestBook.setItem(item);
    bestBook.setRentCount(1L);
    return bestBook;
}

public Long increseBestBookCount(){
        this.rentCount = this.getRentCount() +1 ;
        return  this.rentCount;
    }
}
