package screenpackage;

import com.TeamHEC.LocomotionCommotion.Actors.ActorManager;
import com.TeamHEC.LocomotionCommotion.camera.OrthoCamera;
import com.TeamHEC.LocomotionCommotion.entity.EntityManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartMenu extends Screen{
	
	private OrthoCamera camera;
	
	private EntityManager entityManager;
	
	private ActorManager actorManager ;

	@Override
	public void create() {
		camera = new OrthoCamera();
		entityManager = new EntityManager();
		actorManager = new ActorManager();
		actorManager.create();
		
		
		
	}  

	@Override
	public void update() {
		camera.update();
		entityManager.update();
		//actorManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb );
		//actorManager.render(sb);
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
