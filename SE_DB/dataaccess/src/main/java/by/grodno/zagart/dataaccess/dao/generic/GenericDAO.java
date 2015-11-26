package by.grodno.zagart.dataaccess.dao.generic;

public interface GenericDAO <TYPE> {
	
	TYPE getById(Long id);
	
	void deleteById(Long id);

	void insert(TYPE typeObject);
	
}
