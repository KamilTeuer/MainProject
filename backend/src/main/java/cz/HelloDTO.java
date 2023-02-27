package cz;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   // Anotace Data = nemusím dělat gettery a settery.
@AllArgsConstructor      // AllArgsConstructor = Budu mít konstruktor se všemi parametry
public class HelloDTO {
    
    private String name;
}
