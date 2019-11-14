/**
 * 
 */
package com.k15t.pat.registration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k15t.pat.model.Participator;

/**
 * @author NCTR
 *
 */
public interface ParticipatorRepository extends JpaRepository<Participator, Integer> {

}
