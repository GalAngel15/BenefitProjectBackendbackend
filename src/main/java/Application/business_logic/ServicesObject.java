package Application.business_logic;


import java.util.List;
import java.util.Optional;



public interface ServicesObject {
	public Optional<BoundaryObject> getSpecificObj(String id);
	public List<BoundaryObject> getAllObjects();
	
	public	BoundaryObject createObject (BoundaryObject StoreBoundary);
	
	public void deleteAllObjs ();
	
	public void updateObj (String id, BoundaryObject update);
}