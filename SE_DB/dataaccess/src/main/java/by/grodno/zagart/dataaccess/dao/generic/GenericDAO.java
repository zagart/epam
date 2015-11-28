package by.grodno.zagart.dataaccess.dao.generic;

public interface GenericDAO <TYPE> {
	
	TYPE getById(Integer id);
	
	void deleteById(Integer id);

	Integer insert(TYPE typeObject);
	
}
