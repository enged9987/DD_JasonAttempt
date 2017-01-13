package gdx.json;
//https://github.com/Slict?tab=repositories Justin Chester
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Config;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import java.util.ArrayList;

public class JSON extends ApplicationAdapter {
DataStore data; 
    Json json;
    JsonReader reader;
    FileHandle file, file2;    
    TextField text;    
    SpriteBatch batch;    
    Texture img;
    String sLetter = "hello", sInput2;
    ArrayList list;

    @Override
    public void create() {
        data = new DataStore();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");        
        json = new Json();
        file = new FileHandle("myjson.json");
        reader = new JsonReader();        
        data.sInput = sLetter;
        json.toJson(data, file);        
        System.out.println(reader.parse(file).get("sInput").asString());
        file2 = Gdx.files.internal("myjson.json");
        sInput2 = file2.readString();
        /*Config data = new Config();
        data = json.fromJson(Config.class, sInput2);*/
        System.out.println(sInput2);  
        
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //batch.draw(img, 0, 0);
        batch.end();     
        
    }
}
    

   
