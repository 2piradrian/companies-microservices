package com.twopiardrian.companiescrud.repositories;

import com.twopiardrian.companiescrud.entities.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {
}
