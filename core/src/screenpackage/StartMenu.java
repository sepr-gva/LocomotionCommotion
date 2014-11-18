package screenpackage;

import com.TeamHEC.LocomotionCommotion.camera.OrthoCamera;
import com.TeamHEC.LocomotionCommotion.entity.EntityManager;
import com.TeamHEC.LocomotionCommotion.entity.SM_NewGame;
import com.TeamHEC.LocomotionCommotion.entity.Title;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StartMenu extends Screen{
	
	private OrthoCamera camera;
	
	private EntityManager entityManager;

	@Override
	public void create() {
		camera = new OrthoCamera();
		entityManager = new EntityManager();
		
		
	}  

	@Override
	public void update() {
		camera.update();
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb );
		sb.end();
	}

	@Override 
	public void resize(int width, int height) {
		camera.resize();
		entityManager.update();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
	

}
