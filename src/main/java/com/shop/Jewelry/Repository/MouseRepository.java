/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.Jewelry.Repository;

import com.shop.Jewelry.Model.Imageurl;
import com.shop.Jewelry.Model.Mouse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 04dkh
 */
@Repository
public interface MouseRepository extends JpaRepository<Mouse, Integer> {

    default List<Imageurl> getImageUrlsByMouseId(int mouseId) {
        Optional<Mouse> optionalMouse = findById(mouseId);
        return optionalMouse.map(Mouse::getImageUrl).orElse(Collections.emptyList());
    }
}
