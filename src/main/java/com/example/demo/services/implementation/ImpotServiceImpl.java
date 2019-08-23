package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.ImpotRevenu;
import com.example.demo.repositories.ImpotRevenuRepo;
import com.example.demo.services.ContratService;
import com.example.demo.services.ImpotService;

@Service
public class ImpotServiceImpl implements ImpotService {

	@Autowired
	private ImpotRevenuRepo impotRepo ;
	
	@Autowired
	private ContratService contratService ;
	
	@Override
	public ImpotRevenu getImpot(Long id) {
		return impotRepo.findById(id).get();
	}

	@Transactional
	@Override
	public void deleteImpot(Long id) {
		try {
			impotRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("erreur deleting impot");
		}
		
	}

	@Override
	public List<ImpotRevenu> getAllContratImpot(Long id) {
	Contrat contrat = contratService.getContrat(id);
		return impotRepo.findByContrat(contrat) ;
	}

	@Transactional
	@Override
	public ImpotRevenu saveImpotContrat(ImpotRevenu impot, Contrat contrat) {
		impot.setContrat(contrat);
		return impotRepo.save(impot);
	}

	@Transactional
	@Override
	public ImpotRevenu updateImpotContrat(Long id, ImpotRevenu impot, Contrat contrat) {
		getImpot(id);
		impot.setIdImpotRev(id);
		impot.setContrat(contrat);
		return saveImpotContrat(impot, contrat);
	}

}
